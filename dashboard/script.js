fetch('../weather.json')
  .then(res => res.json())
  .then(data => {
    const temps = data.list.map(e => e.main.temp);
    const labels = data.list.map(e => e.dt_txt.split(" ")[0]);

    const ctx = document.getElementById('forecastChart').getContext('2d');
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: labels.slice(0, 10),
        datasets: [{
          label: 'Temperature (°C)',
          data: temps.slice(0, 10),
          backgroundColor: 'rgba(0,123,255,0.5)'
        }]
      }
    });
  });
