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

            stage('lint checks') {
                steps {
                    sh 'echo lint cases'
                }
            }

            stage('test cases') {
                steps {
                    sh 'echo test cases'
                }
            }

            stage('publish artifacts') {
                steps {
                    sh 'echo publish artifacts'
                    sh 'env'
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