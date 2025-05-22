// Static weather data for demonstration
const weatherData = {
  India: { temp: 34, condition: "Sunny", humidity: 40 },
  USA: { temp: 22, condition: "Cloudy", humidity: 55 },
  Canada: { temp: 10, condition: "Rainy", humidity: 70 },
  Australia: { temp: 28, condition: "Clear", humidity: 45 }
};

const input = document.getElementById("countryInput");
const weatherInfo = document.getElementById("weatherInfo");

// Function to display weather details
function showWeather(country) {
  const countryKey = Object.keys(weatherData).find(
    key => key.toLowerCase() === country.trim().toLowerCase()
  );
  if (countryKey) {
    const data = weatherData[countryKey];
    weatherInfo.innerHTML = `
      <strong>Country:</strong> ${countryKey}<br>
      <strong>Temperature:</strong> ${data.temp}°C<br>
      <strong>Condition:</strong> ${data.condition}<br>
      <strong>Humidity:</strong> ${data.humidity}%
    `;
  } else {
    weatherInfo.textContent = "Weather data not found for this country.";
  }
}

// Handle Enter key press in input
input.addEventListener("keydown", function(event) {
  if (event.key === "Enter") {
    showWeather(input.value);
  }
});

// Also handle click on Submit button
document.getElementById("submitBtn").addEventListener("click", function() {
  showWeather(input.value);
});
