pipeline {
    agent any
    environment {
        NEW_VERSION = '1.0.0'
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
            steps{
                echo "building the application v${NEW_VERSION}"
                script {
                    sh 'mvn compile'
                }
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
                    sh 'mvn test;
                }
            }
        }
        stage("deploy") {
            steps{
                echo "deploying the application ${params.VERSION}"

            }
        }
    }
}