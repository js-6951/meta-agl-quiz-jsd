SUMMARY = "AGL Quiz JSD Image"

LICENSE = "MIT"

require recipes-platform/images/agl-image-flutter-runtimerelease.bb

IMAGE_INSTALL:append = " agl-quiz-jsd"