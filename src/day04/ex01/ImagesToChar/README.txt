1) mkdir target
2) mkdir target/resources
2) javac -d target/ src/java/edu/school21/printer/*/*.java
3) cp src/resources/* target/resources
4) jar cfvm target/images-to-chars-printer.jar src/manifest.txt -C target/ .
5) java -jar target/images-to-chars-printer.jar . 0
6) rm -rf target