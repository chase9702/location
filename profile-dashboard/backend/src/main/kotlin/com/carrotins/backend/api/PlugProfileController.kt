package com.carrotins.backend.api

import com.carrotins.backend.repository.DeviceProductCount
import com.carrotins.backend.repository.InterpolationTripInfo
import com.carrotins.backend.service.PlugProfileService
import io.swagger.v3.oas.annotations.tags.Tag
import com.carrotins.backend.repository.ZeroGpsTripInfo
import com.carrotins.backend.repository.CarProductNameInfo
import org.springframework.web.bind.annotation.*




/**
 * Created by alvin on 2023/07/19.
 */
@Tag(name = "Plug controller")
@RestController
@RequestMapping("/api/plug")
class PlugProfileController(
    private val plugProfileService: PlugProfileService
) {
    @GetMapping("/device-info")
    fun getDeviceData():List<DeviceProductCount>{
        return plugProfileService.getDeviceProductCount()
    }
    @GetMapping("/car-product-name-info")
    fun getCarnmData():List<CarProductNameInfo>{
        return plugProfileService.getCarProductNameInfo()
    }
    @GetMapping("/zero-gps-trip-info")
    fun getZgpsRTData():List<ZeroGpsTripInfo>{
        return plugProfileService.getZeroGpsTripInfo()
    }
    @GetMapping("/interpolation-trip-info")
    fun gettrip02RTData():List<InterpolationTripInfo>{
        return plugProfileService.getInterpolationTripInfo()
    }

    @PostMapping("/click-test")
    fun search(@RequestBody searchData: String): String {
        val result = searchData.toUpperCase()

        return "서버에서 받은 데이터: $result"
    }
}