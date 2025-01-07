import re
import sys
import os

def validate_project_name(project_name):
    """Ensure the project name is valid (e.g., no spaces or special characters)."""
    if not re.match(r'^[a-zA-Z0-9\-_.]+$', project_name):
        print(f"ERROR: '{project_name}' is not a valid project name. Use only letters, numbers, dashes, underscores, and periods.")
        sys.exit(1)

def validate_package_name(package_name):
    """Ensure the package name is a valid Java package (e.g., com.example.project)."""
    if not re.match(r'^[a-z]+(\.[a-z][a-z0-9]*)*$', package_name):
        print(f"ERROR: '{package_name}' is not a valid package name. Use a valid Java package naming convention (e.g., com.example.project).")
        sys.exit(1)

def check_java_version(required_version):
    """Check if the required Java version is installed."""
    try:
        java_version_output = os.popen("java -version 2>&1").read()
        if f'"{required_version}' not in java_version_output:
            print(f"ERROR: Java {required_version} is required but not installed or not in PATH.")
            sys.exit(1)
    except Exception as e:
        print(f"ERROR: Failed to check Java version. Ensure Java is installed and in PATH.\n{e}")
        sys.exit(1)

def check_maven_installed():
    """Check if Maven is installed."""
    try:
        maven_output = os.popen("mvn -v").read()
        if "Apache Maven" not in maven_output:
            print("ERROR: Maven is not installed or not in PATH.")
            sys.exit(1)
    except Exception as e:
        print(f"ERROR: Failed to check Maven installation. Ensure Maven is installed and in PATH.\n{e}")
        sys.exit(1)

if __name__ == "__main__":
    project_name = "{{cookiecutter.project_name}}"
    validate_project_name(project_name)

    package_name = "{{cookiecutter.package_name}}"
    validate_package_name(package_name)

#     required_java_version = "{{cookiecutter.java_version}}"
#     check_java_version(required_java_version)

    check_maven_installed()

    print("All pre-generation checks passed. Proceeding with project generation...")
