module.exports = (grunt) ->
  grunt.loadNpmTasks 'grunt-regarde'
  grunt.loadNpmTasks 'grunt-crx'
  grunt.loadNpmTasks 'grunt-contrib-jshint'

  grunt.initConfig
    crx:
      myHostedPackage:
        src: "src/"
        dest: "metatoron.crx"
        privateKey: "metatoron.pem",

    jshint:
      options:
        curly: true
        eqeqeq: true
        eqnull: true
        browser: true
        globals:
          jQuery: true
        force: true
        ignores: [ "src/jquery-2.0.3.min.js" ]
      files: "src/*.js"

    regarde:
      js:
        files: "src/"
        tasks: ['crx', 'jshint']

  grunt.registerTask 'default', [
    'jshint',
    'crx',
    'regarde'
  ]

