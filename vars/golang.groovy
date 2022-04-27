def call() {


    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

        triggers {
            pollSCM('*/2 * * * *')
        }

        stages {
            stage('compile the code') {
                steps {
                    sh 'echo compile the ${COMPONENT} code'
                }
            }

            stage('check the code quality') {
                steps {
                    sh 'echo check the code quality'
                }
            }

            stage('lint checks') {
                steps {
                    sh 'echo lint checks'
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
                cleanws()
            }
        }
    }

}