def sonarQube() {
    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.2.106:9000 -Dsonar.login=admin -Dsonar.password=admin123'

}