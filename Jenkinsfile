pipeline {
    agent { label 'agent1' }

    parameters {
        string(name: 'testData1', defaultValue: 'Default1', description: 'First j test data')
        string(name: 'testData2', defaultValue: 'Default2', description: 'Second j test data')
        string(name: 'testData3', defaultValue: 'Default3', description: 'Third j test data')
        string(name: 'testData4', defaultValue: 'Default4', description: 'Fourth j test data')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/balamuralikrishnap-cyber/testngjenkins.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo "Running Maven tests with parameters..."
                bat "\"C:/apache-maven-3.9.11/bin/mvn.cmd\" clean test " +
                    "-DtestData1=${params.testData1} " +
                    "-DtestData2=${params.testData2} " +
                    "-DtestData3=${params.testData3} " +
                    "-DtestData4=${params.testData4}"
            }
        }
    }
}
