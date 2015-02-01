'use strict';
var gulp = require('gulp');
var $ = require('gulp-load-plugins')({
  pattern: ['gulp-*', 'main-bower-files', 'uglify-save-license']
});

var replace = require('gulp-replace');

gulp.task('thymeleaf',['build'], function () {
  return gulp.src('dist/*.html')
    .pipe(replace('src="scripts/', 'th:src="@{scripts/'))
    .pipe(replace('.js">', '.js}">'))
    .pipe(replace('href="styles/', 'th:href="@{styles/'))
    .pipe(replace('.css">', '.css}"/>'))
    .pipe(gulp.dest('dist'));
});
gulp.task('css_font_fix', function () {
  return gulp.src('dist/**/*.css')
    .pipe(replace('../bower_components/bootstrap-sass-official/assets/fonts/bootstrap/', '../fonts/'))
    .pipe(gulp.dest('dist'));
});

gulp.task('copystatic',['thymeleaf','css_font_fix'], function () {
  return gulp.src(
		['dist/**/*.js'
		,'dist/**/*.css'
		,'dist/**/*.png'
		, 'dist/**/*.svg'
		, 'dist/**/*.eot'
		, 'dist/**/*.ttf'
		, 'dist/**/*.woff'])
  .pipe(gulp.dest('../zols-cms-plugin/src/main/resources/static'));
});

gulp.task('copytemplates',['thymeleaf'], function () {
  return gulp.src(['dist/**/*.html'
		//,'!dist/index.html'
		])
  .pipe(gulp.dest('../zols-cms-plugin/src/main/resources/zolstemplates'));
});

gulp.task('release', ['copystatic', 'copytemplates', 'css_font_fix']);
