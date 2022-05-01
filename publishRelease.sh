#echo "Compressing artifacts into one file"
#zip -r artifacts.zip artifacts_folder

#export GITHUB_TOKEN=$$$$$$$$$$$$
#export GITHUB_API=https://git.{your domain}.com/api/v3 # needed only for enterprise
export GITHUB_ORGANIZATION=thatshawt
export GITHUB_REPO=suday-streaming-checklist
export VERSION_NAME=${BUILD_NUMBER}

echo "Deleting release from github before creating new one"
linux-amd64-github-release delete --user ${GITHUB_ORGANIZATION} --repo ${GITHUB_REPO} --tag "${VERSION_NAME}"

echo "Creating a new release in github"
linux-amd64-github-release release --user ${GITHUB_ORGANIZATION} --repo ${GITHUB_REPO} --tag "${VERSION_NAME}" --name "${VERSION_NAME}"

echo "Uploading the artifacts into github"
# shellcheck disable=SC2086
linux-amd64-github-release upload --user ${GITHUB_ORGANIZATION} --repo ${GITHUB_REPO} --tag ${VERSION_NAME} --name "${PROJECT_NAME}-${VERSION_NAME}.jar" --file *.jar
