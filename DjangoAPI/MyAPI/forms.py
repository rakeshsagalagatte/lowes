from django import forms 

class MyForm(forms.Form):
	name = forms.CharField()
	email=forms.CharField(label='E-Mail')
	subject = forms.CharField(required=False)
