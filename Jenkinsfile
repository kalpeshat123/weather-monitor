pipeline {
    agent any

    stages {
        stage('Pull City & Fetch Weather') {
            steps {
                // Ensure Python is available, and the file path is correct
                sh 'python3 weather-data/fetch_weather.py'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image from Dockerfile in project root
                sh 'docker build -t weather-dashboard .'
            }
        }

        stage('Run Container') {
            steps {
                // Stop and remove old container if running (prevents port conflict)
                sh 'docker rm -f weather-ui || true'

                // Run the new container on port 8090:90
                sh 'docker run -d -p 8090:90 --name weather-ui weather-dashboard'
            }
        }
    }
}
