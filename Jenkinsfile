pipeline {
    agent any
    tools {
        maven 'maven-3.9.9' // Asegúrate que el nombre en Jenkins coincida
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/DavidRC1629/api-orders.git'
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Docker Build & Deploy') {
            steps {
                sh 'docker build -t api-orders:latest .'
                // Eliminar contenedor previo si existe para evitar conflictos
                sh 'docker rm -f api-orders-container || true'
                sh 'docker run -d -p 8080:8080 --name api-orders-container api-orders:latest'
            }
        }
    }
}
