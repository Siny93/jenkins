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
                         addInfoBadge id: '', text: 'DEMO'
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
                when {
                    expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true']) }
                }
                steps {
                    script {
                        //common.publishArtifacts()
                        println 'publish artifacts'
                    }
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