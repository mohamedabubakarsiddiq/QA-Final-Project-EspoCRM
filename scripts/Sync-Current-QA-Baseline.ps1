$ErrorActionPreference = "Stop"

# Run from the local EspoCRM-QA-Automation repository root.
# This script syncs the revised three-module documentation baseline.
# It intentionally does NOT update the Automation Tracker yet.

$source = "C:\Users\SIDDIQ\EspoCRM-QA-Automation"
Set-Location $source

Write-Host "Pulling latest main..."
git pull origin main

$files = @(
    @{ Src="C:\Users\SIDDIQ\EspoCRM-QA-Automation\EspoCRM-SRS-v1.2-Three-Module-Scope.docx"; Dst="01-Requirements\EspoCRM-SRS-v1.2.docx" },
    @{ Src="C:\Users\SIDDIQ\EspoCRM-QA-Automation\EspoCRM-Test-Plan-v1.1-Three-Module-Scope.docx"; Dst="02-Test-Plan\EspoCRM-Test-Plan-v1.1.docx" },
    @{ Src="C:\Users\SIDDIQ\EspoCRM-QA-Automation\EspoCRM-Test-Scenarios-v1.2.md"; Dst="03-Test-Cases\EspoCRM-Test-Scenarios-v1.2.md" },
    @{ Src="C:\Users\SIDDIQ\EspoCRM-QA-Automation\EspoCRM-Detailed-Test-Cases-v1.1.xlsx"; Dst="03-Test-Cases\Detailed-test-cases\EspoCRM-Detailed-Test-Cases-v1.1.xlsx" },
    @{ Src="C:\Users\SIDDIQ\EspoCRM-QA-Automation\EspoCRM-Master-RTM-v1.1-Three-Module-Scope-Fixed.xlsx"; Dst="04-RTM\EspoCRM-Master-RTM-v1.1.xlsx" },
    @{ Src="C:\Users\SIDDIQ\EspoCRM-QA-Automation\EspoCRM-Master-Bug-Report-v1.1-Three-Module-Scope.xlsx"; Dst="05-Bug-Reports\EspoCRM-Master-Bug-Report-v1.1.xlsx" },
    @{ Src="C:\Users\SIDDIQ\EspoCRM-QA-Automation\EspoCRM-Manual-Testing-Final-Summary-v1.1-Three-Module-Scope.docx"; Dst="06-Test-Reports\EspoCRM-Manual-Testing-Final-Summary-v1.1.docx" }
)

foreach ($item in $files) {
    if (-not (Test-Path $item.Src)) {
        throw "Missing source file: $($item.Src)"
    }
    $target = Join-Path $source $item.Dst
    $parent = Split-Path $target -Parent
    if (-not (Test-Path $parent)) {
        New-Item -ItemType Directory -Path $parent -Force | Out-Null
    }
    Copy-Item -LiteralPath $item.Src -Destination $target -Force
    Write-Host "Updated $($item.Dst)"
}

# Remove obsolete active documentation files.
$obsolete = @(
    "01-Requirements\EspoCRM-SRS-v1.0.docx",
    "02-Test-Plan\EspoCRM-Test-Plan-v1.0.docx",
    "03-Test-Cases\EspoCRM-Test-Scenarios-v1.0.md",
    "03-Test-Cases\Accounts-Test-Scenarios.txt",
    "03-Test-Cases\Contacts-Test-Scenarios-v1.1.txt",
    "03-Test-Cases\Leads-Test-Scenarios-v1.0.txt",
    "03-Test-Cases\Login-Test-Scenarios-v1.0.txt",
    "03-Test-Cases\Opportunities-Test-Scenarios-v1.0.txt",
    "03-Test-Cases\Detailed-test-cases\EspoCRM-Accounts-Test-Cases-v1.0.xlsx",
    "03-Test-Cases\Detailed-test-cases\EspoCRM-Contacts-Test-Cases-v1.0.xlsx",
    "03-Test-Cases\Detailed-test-cases\EspoCRM-Leads-Test-Cases-v1.0.xlsx",
    "03-Test-Cases\Detailed-test-cases\EspoCRM-Login-Test-Cases-v1.0.xlsx",
    "03-Test-Cases\Detailed-test-cases\EspoCRM-Opportunity-Test-cases-v1.0.xlsx",
    "04-RTM\Accounts-RTM-v1.0.xlsx",
    "04-RTM\Accounts-RTM-v1.1.xlsx",
    "04-RTM\Contacts-RTM-v1.0.xlsx",
    "04-RTM\EspoCRM-Master-RTM-v1.0.xlsx",
    "04-RTM\Leads-RTM-v1.0.xlsx",
    "04-RTM\Login-RTM-v1.0.xlsx",
    "04-RTM\Opportunities-RTM-v1.0.xlsx",
    "05-Bug-Reports\Accounts-Bug-Report-v1.0.xlsx",
    "05-Bug-Reports\Contacts-Bug-Report-v1.0.xlsx",
    "05-Bug-Reports\EspoCRM-Master-Bug-Report-v1.0.xlsx",
    "05-Bug-Reports\Leads-Bug-Report-v1.0.xlsx",
    "05-Bug-Reports\Login-Bug-Report-v1.0.xlsx",
    "05-Bug-Reports\Opportunities-Bug-Report-v1.0.xlsx",
    "06-Test-Reports\EspoCRM-Manual-Testing-Final-Summary-v1.0.docx"
)

foreach ($relative in $obsolete) {
    $path = Join-Path $source $relative
    if (Test-Path $path) {
        Remove-Item -LiteralPath $path -Force
        Write-Host "Removed $relative"
    }
}

Write-Host "Historical 11-Test-Reports artifacts are retained."
Write-Host "Automation Tracker is intentionally not changed in this sync."

git status --short
git add 01-Requirements 02-Test-Plan 03-Test-Cases 04-RTM 05-Bug-Reports 06-Test-Reports README.md
git commit -m "Align QA documentation to three-module baseline"
git push origin main

Write-Host "Documentation baseline pushed successfully."
