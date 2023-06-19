// As well as the TFT_eSPI library:
// https://github.com/Bodmer/TFT_eSPI
// the sketch need the JPEG Decoder library. This can be loaded via the Library Manager.
// or can be downloaded here:
// https://github.com/Bodmer/JPEGDecoder

//----------------------------------------------------------------------------------------------------

#include <SPI.h>
#include <TFT_eSPI.h>

TFT_eSPI tft = TFT_eSPI();

#include <JPEGDecoder.h>

#define minimum(a,b)     (((a) < (b)) ? (a) : (b))

#include "jpeg4.h"
#include "vampipo.h"
#include "sede.h"
#include <BluetoothSerial.h>
const int sensorPin1 = 34; 
const int sensorPin2 = 36;
BluetoothSerial SerialBT;  // Objeto BluetoothSerial

uint32_t icount = 0;

//####################################################################################################
void setup() {
  //SerialBT.begin("Pippo");  // Inicia o Bluetooth e define o nome do dispositivo
  Serial.println("Aguardando conexão Bluetooth...");
  delay(100);  // Pequeno atraso para evitar sobrecarga do loop

  Serial.begin(115200);
  tft.begin();
  tft.setRotation(3);  // portrait
  tft.fillScreen(0xFFFF);

  
}


void loop() {
  // if (SerialBT.available()) {  // Verifica se há dados disponíveis para leitura
  //   char data = SerialBT.read();  // Lê o dado recebido via Bluetooth
  //   Serial.print("Dado recebido: ");
  //   Serial.println(data);
  // }
  
  delay(1000);
  checkSensors();
}

//####################################################################################################
void drawArrayJpeg(const uint8_t arrayname[], uint32_t array_size, int xpos, int ypos) {

  int x = xpos;
  int y = ypos;

  JpegDec.decodeArray(arrayname, array_size);
  
  
  renderJPEG(x, y);
  
  Serial.println("##fim##");
}

void renderJPEG(int xpos, int ypos) {

  uint16_t *pImg;
  uint16_t mcu_w = JpegDec.MCUWidth;
  uint16_t mcu_h = JpegDec.MCUHeight;
  uint32_t max_x = JpegDec.width;
  uint32_t max_y = JpegDec.height;

  uint32_t min_w = minimum(mcu_w, max_x % mcu_w);
  uint32_t min_h = minimum(mcu_h, max_y % mcu_h);

  uint32_t win_w = mcu_w;
  uint32_t win_h = mcu_h;

  uint32_t drawTime = millis();

  max_x += xpos;
  max_y += ypos;

  while (JpegDec.read()) {

    pImg = JpegDec.pImage ;

    int mcu_x = JpegDec.MCUx * mcu_w + xpos;  
    int mcu_y = JpegDec.MCUy * mcu_h + ypos;

    if (mcu_x + mcu_w <= max_x) win_w = mcu_w;
    else win_w = min_w;

    if (mcu_y + mcu_h <= max_y) win_h = mcu_h;
    else win_h = min_h;

    if (win_w != mcu_w)
    {
      uint16_t *cImg;
      int p = 0;
      cImg = pImg + win_w;
      for (int h = 1; h < win_h; h++)
      {
        p += mcu_w;
        for (int w = 0; w < win_w; w++)
        {
          *cImg = *(pImg + w + p);
          cImg++;
        }
      }
    }

    uint32_t mcu_pixels = win_w * win_h;

    tft.startWrite();

    if (( mcu_x + win_w ) <= tft.width() && ( mcu_y + win_h ) <= tft.height())
    {
      tft.setAddrWindow(mcu_x, mcu_y, win_w, win_h);

      while (mcu_pixels--) {
        tft.pushColor(*pImg++);
      }
    }
    else if ( (mcu_y + win_h) >= tft.height()) JpegDec.abort();

    tft.endWrite();
  }
  drawTime = millis() - drawTime;
}

void showTime(uint32_t msTime) {

  tft.setCursor(0, 0);
  tft.setTextFont(1);
  tft.setTextSize(2);
  tft.setTextColor(TFT_WHITE, TFT_BLACK);
  tft.print(F(" JPEG drawn in "));
  tft.print(msTime);
  tft.println(F(" ms "));
}

void checkSensors() {
  
  int sensorValueLuminosity = analogRead(sensorPin1);
  int percentLuminosity = map(sensorValueLuminosity, 0, 4095, 0, 100);

  int sensorValueHumidity = analogRead(sensorPin2);
  int percentHumidity = map(sensorValueHumidity, 0, 4095, 100, 0);
  percentHumidity = constrain(percentHumidity, 0, 50);

  if (percentLuminosity >= 70) {
    drawArrayJpeg(vampippo, sizeof(vampippo), 0, 0);
  }
  else if (percentHumidity <= 40) {
    drawArrayJpeg(sede, sizeof(sede), 0, 0);
  }
  else {
    drawArrayJpeg(EagleEye, sizeof(EagleEye), 0, 0);
  }
}


// void sensorLoop() {
//   const int sensorPin = 34;

//   int sensorValue = analogRead(sensorPin);
//   int percentluminosity = map(sensorValue, 0, 4095, 0, 100);

//   // Imprime o valor lido no Monitor Serial
//   Serial.print("Luz: ");
//   Serial.println(percentluminosity);
//   while (percentluminosity >= 70) {
//   drawArrayJpeg(vampippo, sizeof(vampippo), 0, 0);

//   // Atualiza o valor de percentluminosity
//   sensorValue = analogRead(sensorPin);
//   percentluminosity = map(sensorValue, 0, 4095, 0, 100);
  
//   delay(1000);
// }
// }


// void sensorUmid() {
//   const int sensorPin = 36; 

//   int sensorValue = analogRead(sensorPin);  // Lê o valor analógico do sensor
  
//   // Converte o valor lido em um percentual de umidade do solo (0-100%)
//   int percentHumidity = map(sensorValue, 0, 4095, 100, 0);
//   percentHumidity = constrain(percentHumidity, 0, 50);

//   String umidade = String(percentHumidity*2);

 
//   // Imprime o valor de umidade do solo no Monitor Serial
//   Serial.print("Agua:");
//   Serial.print(percentHumidity*2);
//   Serial.println("%");
//   while (percentHumidity <= 50) {
//   //drawArrayJpeg(sede, sizeof(sede), 0, 0);
//   int sensorValue = analogRead(sensorPin);  // Lê o valor analógico do sensor
//   int percentHumidity = map(sensorValue, 0, 4095, 100, 0);
//   }
//   delay(1000);  // Aguarda um segundo antes de fazer uma nova leitura
