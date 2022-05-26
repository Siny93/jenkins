def sonarQube() {
    //sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.2.106:9000 -Dsonar.login=admin -Dsonar.password=admin123'
    //sh 'sonar-quality-gate.sh admin admin123 172.31.2.106 ${COMPONENT}'
    println 'sonarqube testing'

}

def publishArtifacts() {
//    if(env.GIT_BRANCH == "*tag*") {
//        println 'ran on tag'
//    } else {
//        Utils.markStageSkippedForConditional('publish Artifacts')
//    }
    sh '''
      curl -f -v -u ${NEXUS_USR}:${NEXUS_PSW} --upload-file ${COMPONENT}-${gitTag}.zip http://nexus.roboshop.internal:8081/repository/${COMPONENT}/${COMPONENT}-${gitTag}.zip
    '''

}

def prepareArtifacts() {
    if (env.PROG_LANG == "nodejs" && env.VERSION == "6") {
        sh '''
          npm install
          zip -r ${COMPONENT}-${gitTag}.zip node_modules server.js
          ls -ltr

        '''
    }


    if(env.PROG_LANG == "java" && env.VERSION == "1.8") {
        sh '''
          mvn clean package
          mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
          zip -r ${COMPONENT}-${gitTag}.zip ${COMPONENT}.jar

        '''
    }

    if(env.PROG_LANG == "python" && env.VERSION == "3") {
        sh '''
          zip -r ${COMPONENT}-${gitTag}.zip requirements.txt *.py ${COMPONENT}.ini

        '''
    }

    if(env.PROG_LANG == "golang" && env.VERSION == "1.15") {
        sh '''
          go mod init dispatch
          go get
          go build
          zip -r ${COMPONENT}-${gitTag}.zip ${COMPONENT}

        '''
    }

    if(env.PROG_LANG == "angular") {
        sh '''
          cd static
          zip -r ../${COMPONENT}-${gitTag}.zip ${COMPONENT}

        '''
    }


}