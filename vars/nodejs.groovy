def call() {


    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

//        triggers {
//            pollSCM('H/2 * * * *')
//        }

        environment {
            PROG_LANG = "nodejs"
        }

        stages {

            stage('label builds') {
                steps {
                    script {
                        def gitTag = GIT_BRANCH.split('/').last()
                        addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${gitTag}"
                    }
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