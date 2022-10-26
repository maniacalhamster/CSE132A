(ls *.ipynb).Name | % {
$name = $_;
if ($name -match 'L\d-') { 
  $replacement = $name -replace 'L(\d)-', 'L0$1-';
  Write-Output "Renaming $name with $replacement";
  mv $name $replacement;  
}
}
