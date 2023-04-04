SUMMARY = "Flutter App which displays name for GSOC AGL quiz"
MAINTAINER = "Jaspreet Dua <jas.dua1998@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# FILESEXTRAPATHS:prepend := "${THISDIR}/systemd:"
SRC_URI:append = "git://git@github.com/js-6951/agl-quiz-jsd.git;protocol=ssh;branch=main \
           file://agl_quiz_jsd-debug.json \
           file://agl_quiz_jsd-profile.json \
           file://agl_quiz_jsd-release.json \
           file://agl_quiz_jsd.service \
"
SRCREV = "${AUTOREV}"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*         Adding Layer AGL Quiz JSD           *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

# flutter-app
#############
S = "${WORKDIR}/git"
PUBSPEC_APPNAME = "agl_quiz_jsd"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"
FLUTTER_BUILD_ARGS = "bundle -v"

inherit flutter-app 

APP_CONFIG = "agl_quiz_jsd-release.json"
APP_CONFIG:class-runtimedebug = "agl_quiz_jsd-debug.json"
APP_CONFIG:class-runtimeprofile = "agl_quiz_jsd-profile.json"

do_install:append(){
    install -D -m 0644 ${WORKDIR}/agl_quiz_jsd.service ${D}${systemd_user_unitdir}/agl_quiz_jsd.service
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    ln -s ../agl_quiz_jsd.service ${D}${systemd_user_unitdir}/agl-session.target.wants/agl_quiz_jsd.service

    install -D -m 0644 ${WORKDIR}/${APP_CONFIG} ${D}${datadir}/flutter/agl_quiz_jsd.json

    install -d ${D}${sysconfdir}/xdg/AGL
}

FILES:${PN} += "${datadir} ${systemd_user_unitdir} ${sysconfdir}/xdg/AGL"

