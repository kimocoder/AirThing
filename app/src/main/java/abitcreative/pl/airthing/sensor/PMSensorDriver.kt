/*
 * (c) Neofonie Mobile GmbH (2017)
 *
 * This computer program is the sole property of Neofonie Mobile GmbH (http://mobile.neofonie.de)
 * and is protected under the German Copyright Act (paragraph 69a UrhG).
 *
 * All rights are reserved. Making copies, duplicating, modifying, using or distributing
 * this computer program in any form, without prior written consent of Neofonie Mobile GmbH, is prohibited.
 * Violation of copyright is punishable under the German Copyright Act (paragraph 106 UrhG).
 *
 * Removing this copyright statement is also a violation.
 */
package abitcreative.pl.airthing.sensor

import android.util.Log
import com.google.android.things.pio.PeripheralManagerService
import com.google.android.things.pio.UartDevice
import com.google.android.things.userdriver.UserSensorDriver
import com.google.android.things.userdriver.UserSensorReading
import java.io.IOException

/**
 * Created by mdabrowski on 18/01/17.
 */
class PMSensorDriver() : UserSensorDriver() {
  var online = false

  companion object {
    val TAG = javaClass.simpleName
    val SET_PIN_GPIO = "??"
    val RESET_PIN_GPIO = "??"
  }

  private val periferialManager = PeripheralManagerService()
  private val uart: UartDevice

  init {

    val gpioPorts = periferialManager.gpioList
    Log.d(TAG, "avaliable gpioList")
    gpioPorts.forEach { Log.d(TAG, it) }

    val uartDevices = periferialManager.uartDeviceList
    Log.d(TAG, "avaliable uarts")
    uartDevices.forEach { Log.d(TAG, it) }
    uart = periferialManager.openUartDevice(uartDevices.first())


  }

  @Throws(IOException::class)
  override fun read(): UserSensorReading? {
    if (online.not()) {
      return null
    }

    return null
  }

  @Throws(IOException::class)
  override fun setEnabled(enabled: Boolean) {
    online = enabled
    //active low
    // reset high then low
  }
}
