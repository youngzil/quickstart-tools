Jenkins 命令行
你可以通过命令行工具操作Jenkins的许多特性。你可以通过 Wiki获得更多信息。作为开始，你可以下载jenkins-cli.jar，然后运行下列命令：

java -jar jenkins-cli.jar -s http://10.11.20.102:8090/ help
可用的命令
add-job-to-view	Adds jobs to view.
build	Builds a job, and optionally waits until its completion.
cancel-quiet-down	Cancel the effect of the "quiet-down" command.
clear-queue	Clears the build queue.
connect-node	Reconnect to a node(s)
console	Retrieves console output of a build.
copy-job	Copies a job.
create-job	Creates a new job by reading stdin as a configuration XML file.
create-node	Creates a new node by reading stdin as a XML configuration.
create-view	Creates a new view by reading stdin as a XML configuration.
delete-builds	Deletes build record(s).
delete-job	Deletes job(s).
delete-node	Deletes node(s)
delete-view	Deletes view(s).
disable-job	Disables a job.
disconnect-node	Disconnects from a node.
enable-job	Enables a job.
get-job	Dumps the job definition XML to stdout.
get-node	Dumps the node definition XML to stdout.
get-view	Dumps the view definition XML to stdout.
groovy	Executes the specified Groovy script.
groovysh	Runs an interactive groovy shell.
help	Lists all the available commands or a detailed description of single command.
install-plugin	Installs a plugin either from a file, an URL, or from update center.
install-tool	Performs automatic tool installation, and print its location to stdout. Can be only called from inside a build. [deprecated]
keep-build	Mark the build to keep the build forever.
list-changes	Dumps the changelog for the specified build(s).
list-jobs	Lists all jobs in a specific view or item group.
list-plugins	Outputs a list of installed plugins.
login	Saves the current credentials to allow future commands to run without explicit credential information. [deprecated]
logout	Deletes the credentials stored with the login command. [deprecated]
offline-node	Stop using a node for performing builds temporarily, until the next "online-node" command.
online-node	Resume using a node for performing builds, to cancel out the earlier "offline-node" command.
quiet-down	Quiet down Jenkins, in preparation for a restart. Don’t start any builds.
reload-configuration	Discard all the loaded data in memory and reload everything from file system. Useful when you modified config files directly on disk.
reload-job	Reload job(s)
remove-job-from-view	Removes jobs from view.
restart	Restart Jenkins.
safe-restart	Safely restart Jenkins.
safe-shutdown	Puts Jenkins into the quiet mode, wait for existing builds to be completed, and then shut down Jenkins.
session-id	Outputs the session ID, which changes every time Jenkins restarts.
set-build-description	Sets the description of a build.
set-build-display-name	Sets the displayName of a build.
set-build-parameter	Update/set the build parameter of the current build in progress. [deprecated]
set-build-result	Sets the result of the current build. Works only if invoked from within a build. [deprecated]
shutdown	Immediately shuts down Jenkins server.
update-job	Updates the job definition XML from stdin. The opposite of the get-job command.
update-node	Updates the node definition XML from stdin. The opposite of the get-node command.
update-view	Updates the view definition XML from stdin. The opposite of the get-view command.
version	Outputs the current version.
wait-node-offline	Wait for a node to become offline.
wait-node-online	Wait for a node to become online.
who-am-i	Reports your credential and permissions.

