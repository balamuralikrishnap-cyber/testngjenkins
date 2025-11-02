pipeline {
    agent { label 'agent1' }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running Maven tests on agent1'
                bat '"C:\apache-maven-3.9.11\\bin\\mvn.cmd" clean test -DtestData1=MavenData1 -DtestData2=MavenData2 -DtestData3=MavenData3 -DtestData4=MavenData4'
            }
        }

        stage('Post Build') {
            steps {
                echo 'Build complete!'
            }
        }
    }
}
