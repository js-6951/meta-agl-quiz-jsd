# AGL Preliminary Quiz - Yocto Layer & Image Recipe

## meta-agl-quiz-jsd

This README file contains information on the contents of the meta-agl-quiz-jsd layer.

The Flutter app is hosted [here](https://github.com/js-6951/agl-quiz-jsd).

Dependencies
============

 - agl-image-flutter-runtimedebug

### Prerequisites:

[Prepare the Build Host](https://docs.automotivelinux.org/en/octopus/#01_Getting_Started/02_Building_AGL_Image/02_Preparing_Your_Build_Host/)

[Downlaod AGL](https://docs.automotivelinux.org/en/octopus/#01_Getting_Started/02_Building_AGL_Image/03_Downloading_AGL_Software/)

[Initialize the build environment](https://docs.automotivelinux.org/en/octopus/#01_Getting_Started/02_Building_AGL_Image/04_Initializing_Your_Build_Environment/)

For a minimal QEMU image:

```
source meta-agl/scripts/aglsetup.sh -m qemux86-64 -b qemux86-64 agl-devel agl-flutter
```

Please ensure that the environment has been sourced using the command:

```
cd $AGL_TOP/<<branch name>> 
source qemux86-64/agl-init-build-env   
```

### Adding the layer and building the image:

This layer can be installed by cloning into the AGL/{release}/ directory using the commands:

```
cd $AGL_TOP/<<branch name>> 
git clone git@github.com:js-6951/meta-agl-quiz-jsd.git
bitbake-layers add-layer meta-agl-quiz-jsd
```

To build the layer:

```
bitbake agl-quiz-jsd
```

To build the image:

```
bitbake agl-quiz-jsd-image
```
### Running the image on QEMU:

Source the environment and boot:

```
cd $AGL_TOP/<<branch name>>/qemux86_64
source agl-init-build-env   
runqemu kvm serialstdio slirp publicvnc
```
![Booting the image](https://github.com/js-6951/meta-agl-quiz-jsd/blob/main/qemu_booting.png)

Connect to the QEMU machine via VNC (Port 0):

![VNC Viewer Output](https://github.com/js-6951/meta-agl-quiz-jsd/blob/main/qemu_booted.png)
