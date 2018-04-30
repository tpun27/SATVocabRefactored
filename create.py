import subprocess

repoPath = subprocess.check_output(["git", "rev-parse", "--show-toplevel"])
repoName = repoPath[repoPath.rfind("/")+1:]

logOutput = subprocess.check_output(["git", "log", "--pretty=oneline", "--reverse"])
logArray = logOutput.split("\n")

repoURL = subprocess.check_output(["git", "ls-remote", "--get-url"])
repoURL = repoURL[:-5] + "/commit/"

# Repo Name
myFile = open("README.md", "w+")
myFile.write("# " + repoName)
myFile.write("\n")

# Commit Messages
stepCount = 0
for line in logArray:
    if "step-" in line:
        myFile.write("- ")
        myFile.write(line[line.find("step-"):])
        myFile.write(" ([Diff][diff-" + str(stepCount) + "])")
        myFile.write("\n")
        stepCount += 1

# Diff Links
myFile.write("\n")
for stepNum in xrange(stepCount):
    myFile.write("[diff-" + str(stepNum) + "]: ")
    myFile.write(repoURL)
    tempIndex = logArray[stepNum].find(" ")
    myFile.write(logArray[stepNum][:tempIndex])
    myFile.write("\n")
myFile.close()