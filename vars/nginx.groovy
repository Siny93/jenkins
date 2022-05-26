def call() {


    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

//        triggers {
//            pollSCM('H/2 * * * *')
//
//        }

        environment {
            PROG_LANG = "angular"
            VERSION = ""
            NEXUS = credentials('NEXUS')
        }

        stages {


            stage('label builds') {
                steps {
                    script {
                        env.gitTag = GIT_BRANCH.split('/').last()
                        addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${gitTag}"
                    }
                }
            }


            stage('compile the code') {
                steps {
                    sh 'mvn compile'
                }
            }


            stage('check the code quality') {
                steps {
                    script {
                        common.sonarQube()
                    }
                }
            }

            stage('lint checks') {
                steps {
                    sh 'echo test cases'
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
                        common.prepareArtifacts()
                        common.publishArtifacts()
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
