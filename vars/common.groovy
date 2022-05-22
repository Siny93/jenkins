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

}
//
//def prepareArtifacts() {
//    println PROG_LANG
//
//
//}