## Create a ROS model from your code

Please be sure that the tool is installed and your workspace setup, see the [installation guide](../README.md) for further details.

To extract your model from ROS code ou have 3 options:
- [Use the available web interface to autogenerate models from code hosted on GitHub](#cloud)
- [Call our docker container configuration for the extraction from a GitHub hosted repository (requires only the installation of Docker)](#docker-container)
- [Use a local build of your ROS package (requires the local installation of HAROS)](#local-ros-workspace)

### Cloud

Under the link [Model extractor](http://ros-model.seronet-project.de/) a web service to extract automatically models from existing open source ROS packages is available. The user only has to give as input the URL address of the repository (for example https://github.com/ipa320/cob_driver), the name of the package that contains the node to be analysed (for example cob_sick_s300) and the name of th node ( for example cob_sick_s300). The resulted model will be displayed on the right side of the window.

![alt text](images/cob_sick_s300_cloud.png)

### Docker container

Clone the repository [ros-model-cloud](https://github.com/ipa320/ros-model-cloud) and follow its [documentation instructions](https://github.com/ipa320/ros-model-cloud/tree/master/extractor-interface)

Save the result content of the extraction as a ".ros" file in your tooling workspace.

To check the created model open the file representation.aird with the Aird editor and in the menu representations choose the "component" option and press "New.." then choose the Artifact entity of your "*.ros" model and press finish.

### Local ROS workspace

:bangbang::bangbang: this section requires a local ROS installation

To extract the model we use static code analysis techniques, concretely the framework HAROS. To analyse a local ROS package you have first to install and setup [HAROS](../tools/README.md#model-extractor-using-static-code-analysis).

Once HAROS is installed and your workspace built you can invoke the extractor of ROS models from the tooling, by pressing the icon "Import ROS model":

![alt text](images/import_ros_model.png)

Choose the directory that should hold your model and press "Next >" a new dialog window will ask you for the name of the ROS package that contains your node and the name of the node. Finally you have to specify the workspace where it was build by choosing the *compile_commands.json* file. This file is always located under your *catkin_ws/build* directory when you build your workspace using the make command option *-DCMAKE_EXPORT_COMPILE_COMMANDS=1*.

![alt text](images/compile_commands.png)

To check the created model open the file representation.aird with the Aird editor and in the menu representations choose the "component" option and press "New.." then choose the Artifact entity of your "*.ros" model and press finish.
