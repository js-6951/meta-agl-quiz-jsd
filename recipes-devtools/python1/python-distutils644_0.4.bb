SUMMARY = "python-distutils"
SECTION = "devel/python"

LICENSE = "MIT"

RDEPENDS:${PN} += "python3-setuptools"

PYPI_PACKAGE = "distutils644"
inherit pypi setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/22/2b/389faf08bb9e75f2ca41b16a17b26bd2cbce842602882b7353752c1fc7fe/distutils644-0.4.tar.gz"
SRC_URI[md5sum] = "8cc5fc5f7aaedff604243749e66dfe55"
SRC_URI[sha256sum] = "1d2eb8ba675da764ca1b26e732f44a26734df1736285697e42fefe270a72cddf"

