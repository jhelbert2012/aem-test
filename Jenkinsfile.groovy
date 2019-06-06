pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
       		dir ( 'sfdc-www' ) {
                	withMaven(maven: 'mvn311'){
                    		sh 'mvn clean package site -Dmaven.site.skip=false -DstagingDirectory=${WORKSPACE}/report -Dnexus.site.url=http://nexusprod:8080/nexus/content/groups/public -Ddependency.locations.enabled=false -T 1C --no-snapshot-updates'
                	}
		}
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
