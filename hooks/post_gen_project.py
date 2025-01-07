import os
import subprocess

def init_git():
    subprocess.run(["git", "init"])
    subprocess.run(["git", "add", "."])
    subprocess.run(["git", "commit", "-m", "Initial commit"])

if __name__ == "__main__":
    init_git()
