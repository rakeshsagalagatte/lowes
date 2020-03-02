# Lowes 

# I Hosted in https://www.pythonanywhere.com/ web services 

## Try to clone in home directroy of server
``` js
git clone https://www.github.com/rakeshsagalagatte/lowes.git
```


create python3.8 or greater than  3.5  virtual environment by using command :

## Create python3.8 or greater than  3.5  virtual environment by using command :

``` js
virtualenv -p /usr/bin/python3.8 blokada
```
I entered virtual name as blokada , U can enter any name doesn't matter

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

And Edit in ALLOW_HOSTS as like :

``` js 
ALLOWED_HOSTS = ['rakeshsagalagatte.pythonanywhere.com'] 
                   |
                   |CHANGE TO 
                   |
                   V
ALLOWED_HOSTS = ['YOUR DOMAIN NAME ']                   

```




**Collect all static files**

``` js 
python3 manage.py collectstatic
```

Since I hosted in pythonanywhere.com web services , I will explain In that.

In pythonanywhere website go to web in `Static files` part  Under  `URL` heading 
`Enter the URL` as `static` and
`Enter Path` as `/home/{username of server machine}/lowes/DjangoAPI/static/`

AND 

***In virtualenv Part***
 Enter your virtual environment name As I given `blokada` 

AND 

***In CODE Part***
- Give Python version above 3.5 like `python 3.8`.
- Overwrite content of `WSGI configuration file:
/var/www/rakeshsagalagatte_pythonanywhere_com_wsgi.py` 

to 

``` js 
# +++++++++++ DJANGO +++++++++++
# To use your own django app use code like this:
import os
import sys
#
## assuming your django settings file is at '/home/{username of server}/mysite/mysite/settings.py'
## and your manage.py is is at '/home/{username of server}/mysite/manage.py'
path = '/home/{username of server}/lowes/DjangoAPI'
if path not in sys.path:
    sys.path.append(path)
#
os.environ['DJANGO_SETTINGS_MODULE'] = 'DjangoAPI.settings'
#
## then:
from django.core.wsgi import get_wsgi_application
application = get_wsgi_application()

```
# Till now DjangoAPI part is Over 

# Now In Android part

***If you want to use APP***

- Go to APP folder take 2 files to your Android mobile and Give the privilege to developer in your mobile settings and install the app .
- Go to singup option and enter username , password , and mobile number as randomly and click on signup button .
- It will take you to next page 
- In next page click on last Button it will make the connection gives the name of user 

## Till now working flow is there 
 ` App part is under processing It is under processing `












