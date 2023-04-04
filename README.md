# AGL Preliminary Quiz - Yocto Layer & Image Recipe

## meta-agl-quiz-jsd

This README file contains information on the contents of the meta-agl-quiz-jsd layer.

The Flutter app is hosted [here]().

Dependencies
============

 - agl-image-flutter-runtimedebug

Patches
=======

Please submit any patches against the meta-agl-quiz-jsd layer to the xxxx mailing list (xxxx@zzzz.org)
and cc: the maintainer:

Maintainer: Jaspreet Dua <jas.dua1998@gmail.com>

### Prerequisites:

Please ensure that the environment has been sourced using the command:

cd $AGL_TOP/<<branch name>> 
source qemux86-64/agl-init-build-env   

### Adding the layer and building the image:

This layer can be installed by cloning into the AGL/{release}/ directory using the commands:

git clone git@github.com:js-6951/meta-agl-quiz-jsd.git
bitbake-layers add-layer agl-quiz-jsd

To build the image:

bitbake agl-quiz-jsd-image

### Running the image on QEMU:

Copy the image to .agl directory where the runtime is located:

cd .agl
cp /home/jas/AGL/octopus/qemux86-64/tmp/deploy/images/qemux86-64/agl-quiz-jsd-image-qemux86-64.wic.vmdk .
cd ..

Modify the setup_env.sh to boot the correct image:

qemu_run() {
    if [ -z ${QEMU_IMAGE+x} ];
    then
        export QEMU_IMAGE=${FLUTTER_WORKSPACE}/.agl/agl-quiz-jsd-image-qemux86-64.wic.vmdk

*** Insert Screenshot ***

Run the script and start QEMU:

Source setup_env.sh

*** Insert Screenshot ***

qemu_run

*** Insert Screenshot ***

Connect to the QEMU machine via VNC (Port 0):



Start the service (incase it does not automatically launch):

