def call() {


    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

        triggers {
            pollSCM('*/2 * * * *')
        }

        stages {


            stage('check the code quality') {
                steps {
                     script {
                         common.sonarQube()
                     }
                }
            }

            stage('test cases') {
                steps {
                    sh 'echo test cases'
                }
            }


        }

        post {
            always {
                cleanWs()
            }

        }

    }
}