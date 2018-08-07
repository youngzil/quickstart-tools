参考：
https://blog.csdn.net/yubo_725/article/details/52326746

下面就来解释上面的build.xml文件的配置：
（1）build.xml需要遵循一定的格式，这样ant命令才能正确执行，一个build.xml文件是以<project>标签为根节点的，<project>节点中可以指定name属性，表示项目的名称，basedir代表项目的根目录，default表示项目的默认任务名，这里的default属性值为test，则执行ant命令时会找default对应的target去执行（如果ant命令没有指定任务名的话）。
（2）<project>标签中定义了一个<target>标签，该标签表示的就是一个任务，<target>标签中的name属性表示任务名，我们可以在命令行下直接使用ant + 任务名来执行某个特定的任务，例如上面的例子中，我们可以使用ant test命令去执行name值为test的target任务，由于我们在<project>标签中配置了default属性为test，所以在命令行下只需要执行ant命令就可以运行test任务了。
（3）<echo>标签表示在命令行下输出，类似于java中的System.out.println()，在<echo>标签中配置message属性后即可在命令行下打印该属性的值。如上图中显示的[echo]，即为我们配置的message属性的值。
（4）使用${}可以获取某个变量的值，花括号中为变量名，如上图中打印出的C:\Users\yubo7\Desktop\TestAnt，即为basedir的值，由于在<project>标签中我们给basedir属性的值为空，所以basedir的值默认为build.xml所在的路径。



ant -help

执行指定ant文件
ant -buildfile <file>      use given buildfile
    -file    <file>              ''
    -f       <file> 
