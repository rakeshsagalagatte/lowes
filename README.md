# Lowes 

## 
``` js
git clone https://www.github.com/rakeshsagalagatte/lowes.git
```


create python3.8 or greater than  3.5  virtual environment by using command :

## Create python3.8 or greater than  3.5  virtual environment by using command :

``` js
virtualenv -p /usr/bin/python3.8 blokada
```


##  To enter into the virtual environment 

``` js
source blokada/bin/activate  

cd lowes/DjangoAPI
```

## Install the Django and dependencies

``` js

sudo python3 -m ensurepip

pip install --upgrade pip    

pip install django 

pip install djangoframework 

pip install numpy   
```

## After all installation check whether you are getting these many packages or not by entering command

pip freeze 

**Out Put is :**

``` js 
asgiref==3.2.3
Django==3.0.3
djangorestframework==3.11.0
numpy==1.18.1
pytz==2019.3
sqlparse==0.3.0
```


***Edit setting.py*** 

``` js 
cd lowes/DjangoAPI/DjangoAPI/

gedit settings.py   //At last of the settings.py add the followings text

STATIC_ROOT = '/home/{username of your machine}/lowes/DjangoAPI/static/'
```

`//Since I cloned repository in home directory of user , so that I mentioned static_root path in user home directory .`



**Collect all static files**

``` js 
python3 manage.py collectstatic
```






