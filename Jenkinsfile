pipeline {
    agent { label 'agent1' } // runs this pipeline on the agent named agent1

    environment {
        TESTDATA1 = "MavenData1"
        TESTDATA2 = "MavenData2"
        TESTDATA3 = "MavenData3"
        TESTDATA4 = "MavenData4"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                // git 'https://github.com/your-repo.git' // uncomment and update if needed
            }
        }

        stage('Build & Test') {
            steps {
                echo "Running Maven tests on agent1"
                // pass parameters to Maven command
                bat "mvn clean test -DtestData1=${env.TESTDATA1} -DtestData2=${env.TESTDATA2} -DtestData3=${env.TESTDATA3} -DtestData4=${env.TESTDATA4}"
            }
        }

        stage('Post Build') {
            steps {
                echo "Pipeline finished successfully on agent1!"
            }
        }
    }
}
