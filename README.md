<a name="readme-top"></a>
<div align="center">

<h1 align="center">Home Supplies Monitor</h1>
</div>
  <p>
    "Home Supplies Monitor is a web application that helps households keep track of their daily essentials and supplies. It allows users to create a list of items that they use regularly and track their inventory over time.

The app provides an easy-to-use interface for managing and organizing household supplies, making it easier for users to
stay on top of their essential items.

The Home Supplies Monitor is a convenient tool for households to stay organized and ensure they always have the supplies
they need. It helps users save time and effort by providing an easy way to track their inventory and stay on top of
their household essentials."
</p>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#screenshots">Usage</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->

## About The Project

Home Supplies Monitor is a pet project that was developed as a way to learn and practice CRUD (create, read, update,
delete) operations using Spring Boot and Java. In addition to learning these technologies, the project also incorporates
HTML, CSS, Bootstrap, and Docker to provide a robust and polished web application.

While the project was initially developed as a way to exercise and improve coding skills, it has also been designed with
a focus on real-life usability. The goal of the Home Supplies Monitor is to provide households with a convenient and
easy-to-use tool for tracking their daily essentials and supplies, and helping them stay organized and on top of their
household needs.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

[![Java][Java.com]][Java-url]
[![Spring][Spring.io]][Spring-url]
[![MySQL][MySQL.com]][MySQL-url]
[![Docker][Docker.com]][Docker-url]
[![Thymeleaf][Thymeleaf.com]][Thymeleaf-url]
[![Bootstrap][Bootstrap.com]][Bootstrap-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

* Git
* Docker

### Running the App

Clone the repository:

  ```sh
git clone https://github.com/BienkowskiTomasz/Home-Supplies-Monitor.git
  ```

Navigate to the project directory:

  ```sh
cd home-supplies-monitor
  ```

Build and run the app using Docker Compose:

  ```sh
docker-compose up -d
  ```

The app should now be running at http://localhost:8080.

### Stopping the App

You can stop the app by running the following command in the project directory:

  ```sh
docker-compose down
  ```

<!-- Screenshots -->

## Screenshots

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->

## Contact

Tomasz Bieńkowski - it.bienkowski@gmail.com

Project
Link: [https://github.com/BienkowskiTomasz/Home-Supplies-Monitor](https://github.com/BienkowskiTomasz/Home-Supplies-Monitor)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/BienkowskiTomasz/Home-Supplies-Monitor.svg?style=for-the-badge

[contributors-url]: https://github.com/BienkowskiTomasz/Home-Supplies-Monitor/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/BienkowskiTomasz/Home-Supplies-Monitor.svg?style=for-the-badge

[forks-url]: https://github.com/BienkowskiTomasz/Home-Supplies-Monitor/network/members

[stars-shield]: https://img.shields.io/github/stars/BienkowskiTomasz/Home-Supplies-Monitor.svg?style=for-the-badge

[stars-url]: https://github.com/BienkowskiTomasz/Home-Supplies-Monitor/stargazers

[issues-shield]: https://img.shields.io/github/issues/BienkowskiTomasz/Home-Supplies-Monitor.svg?style=for-the-badge

[issues-url]: https://github.com/BienkowskiTomasz/Home-Supplies-Monitor/issues

[license-shield]: https://img.shields.io/github/license/BienkowskiTomasz/Home-Supplies-Monitor.svg?style=for-the-badge

[license-url]: https://github.com/BienkowskiTomasz/Home-Supplies-Monitor/blob/master/LICENSE.txt

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

[linkedin-url]: https://linkedin.com/in/linkedin_username

[product-screenshot]: images/screenshot.png

[Java.com]: https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white

[Java-url]: https://www.java.com/

[Spring.io]: https://img.shields.io/badge/spring-green?style=for-the-badge&logo=spring&logoColor=white

[Spring-url]: https://spring.io/

[MySQL.com]: https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white

[MySQL-url]: https://www.mysql.com/

[Docker.com]: https://img.shields.io/badge/Docker-0DB7ED?style=for-the-badge&logo=docker&logoColor=white

[Docker-url]: https://www.docker.com/

[Thymeleaf.com]: https://img.shields.io/badge/Thymeleaf-7B56C0?style=for-the-badge&logo=thymeleaf&logoColor=white

[Thymeleaf-url]: https://www.thymeleaf.org/

[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white

[Bootstrap-url]: https://getbootstrap.com

### DOCKER

Commands to build and run a docker container:

    docker build --platform linux/amd64 -tHome-Supplies-Monitor .
    docker run -p 8080:8080Home-Supplies-Monitor