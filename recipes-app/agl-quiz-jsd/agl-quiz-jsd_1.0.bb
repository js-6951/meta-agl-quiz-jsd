SUMMARY = "Flutter App which displays name for GSOC AGL quiz"
MAINTAINER = "Jaspreet Dua <jas.dua1998@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# FILESEXTRAPATHS:prepend := "${THISDIR}/systemd:"
SRC_URI:append = "git://git@github.com/js-6951/agl-quiz-jsd.git;protocol=ssh;branch=main"
SRCREV = "${AUTOREV}"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

# flutter-app
#############
S = "${WORKDIR}/git/agl_quiz_jsd"
PUBSPEC_APPNAME = "agl_quiz_jsd"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/flutter"
FLUTTER_BUILD_ARGS = "bundle -v"

inherit flutter-app 

# agl-app
#########
AGL_APP_TEMPLATE = "agl-app-flutter"
AGL_APP_ID = "agl_quiz_jsd"
AGL_APP_NAME = "agl_quiz_jsd"

inherit agl-app

#REQUIRED_DISTRO_FEATURES:append = " systemd"

#SYSTEMD_SERVICE:${PN} = ""
#SYSTEMD_AUTO_ENABLE:${PN} = "enable"

#do_install:append(){
#install -d ${D}${systemd_system_unitdir}
#install -m 0644 agl_quiz_jsd ${D}${systemd_system_unitdir}
#}
#FILES:${PN}:append = " ${systemd_system_unitdir}/"
