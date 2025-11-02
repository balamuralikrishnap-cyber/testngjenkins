pipeline {
    agent { label 'agent1' }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Start Selenium Grid') {
            steps {
                echo 'Starting Dockerized Selenium Grid...'
                bat 'docker-compose up -d'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running tests on Selenium Grid...'
                bat '"C:/apache-maven-3.9.11/bin/mvn.cmd" clean test -DhubURL=http://localhost:4444/wd/hub'
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                echo 'Stopping Dockerized Selenium Grid...'
                bat 'docker-compose down'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}
