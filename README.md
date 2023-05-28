# javacli-do-nothing

POC on java CLI application, with JCommander handling `version` and `help` switch.

## Installation

```bash
sudo curl -L https://siakhooi.github.io/apt/siakhooi-apt.list | sudo tee /etc/apt/sources.list.d/siakhooi-apt.list > /dev/null
sudo curl -L https://siakhooi.github.io/apt/siakhooi-apt.gpg  | sudo tee /usr/share/keyrings/siakhooi-apt.gpg > /dev/null
sudo apt update
sudo apt install siakhooi-java-do-nothing

```

## Run

```bash
java-do-nothing

java-do-nothing -v

java-do-nothing --version

java-do-nothing -h

java-do-nothing --help
```
