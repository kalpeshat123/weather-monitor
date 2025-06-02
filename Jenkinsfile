pipeline {
    agent any

    stages {
        stage('Pull City & Fetch Weather') {
            steps {
                sh 'python3 weather-data/fetch_weather.py'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t weather-dashboard .'
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8080:80 --name weather-ui weather-dashboard'
            }
        }
    }
}
