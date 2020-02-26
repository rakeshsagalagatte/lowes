from django.shortcuts import render
from . models import approvals
from django.core import serializers
from rest_framework import viewsets
from rest_framework.parsers import JSONParser
from . serializers import approvalsSerializers
import numpy as np
from rest_framework.decorators import api_view
from .forms import MyForm 
import json
from django.http import HttpResponse

# Create your views here.
class ApprovalsView(viewsets.ModelViewSet):
	queryset=approvals.objects.all()
	serializer_class=approvalsSerializers
flag=0
def myform(request):
	flag=0;
	if request.method=="POST":
		form=MyForm(request.POST)
		if form.is_valid():
			myform=form.save(commit=False)
			flag=1
	else:
		form=MyForm()

@api_view(["POST"])
def approvereject(request):
	try:
		if flag==1:

			mydata=json.loads(MyForm(request.POST))
			#unit=np.array(list(mydata.values()))
			#unit=unit.reshape(1,-1)
			return HttpResponse(json.dumps(mydata),content_type="application/json")
	except ValueError as e:
		return HttpResponse(e.args[0], status.HTTP_400_BAD_REQUEST)