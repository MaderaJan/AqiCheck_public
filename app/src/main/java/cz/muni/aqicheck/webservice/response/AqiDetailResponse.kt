package cz.muni.aqicheck.webservice.response

data class AqiDetailResponse(
    val status: String,
    val data: AqiDetailWrapperResponse,
)

data class AqiDetailWrapperResponse(
    val aqi: String,
    val attributions: List<Attribution>,
    val city: AqiDetailCityResponse,
    val time: AqiDetailTime,
    val forecast: ForecastWrapper
)

data class Attribution(
    val url: String,
    val name: String
)

data class AqiDetailCityResponse(
    val geo: List<Double>,
    val name: String,
    val url: String
)

data class AqiDetailTime(
    val s: String
)

data class ForecastWrapper(
    val daily: DailyWrapper
)

data class DailyWrapper(
    val pm25: List<ForecastData>
)

data class ForecastData(
    val avg: Long,
    val day: String,
    val max: Long,
    val min: Long
)