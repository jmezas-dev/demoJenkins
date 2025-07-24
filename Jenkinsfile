#!groovy
pipeline {
    agent none
    environment {
        registry = 'jmezas/springservice'
        credential = ''
        NEW_VERSION = '1.0.0'
        dockerImage = ''
    }
    tools {
        maven 'Maven'
    }
    parameters {
        choice(name:'VERSION', choices:['1.1.0', '1.2.0', '1.3.0'], description:'')
        booleanParam(name:'executeTests', defaultValue:true, description: 'Executes tests if true')
    }
    stages {
        stage("build") {
            agent any
            steps {
                echo "building the application v${NEW_VERSION}"
                sh "docker build -t jmezas/springservice:${NEW_VERSION} ."
            }
        }
        stage("test") {
            when {
                expression {
                    params.executeTests == true
                }
            }
            steps {
                echo "testing the application"
                script {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage("deploy") {
            steps{
                echo "deploying the application ${params.VERSION}"
                script {
                    docker.build
                }
            }
        }
    }
}