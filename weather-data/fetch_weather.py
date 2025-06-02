import requests, json

API_KEY = "your_openweather_api_key"

with open("weather-data/city.txt", "r") as f:
    city = f.read().strip()

url = f"https://api.openweathermap.org/data/2.5/forecast?q={city}&appid={API_KEY}&units=metric"
response = requests.get(url)

if response.status_code == 200:
    data = response.json()
    with open("weather.json", "w") as f:
        json.dump(data, f)
    print("Weather data saved.")
else:
    print("Failed to fetch weather data.")
