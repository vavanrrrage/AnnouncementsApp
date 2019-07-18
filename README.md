# AnnouncementsApp

## Библиотеки и архитектура

### Architecture Components - LiveData, ViewModel
### Dependency Injection - Koin
### Navigation - Alligator
### Network - Retrofit2, OkHttp, Gson
### Async - RxJava2
### Views - AutoImageFlipper

## Задание

Описание задания
·       Реализовать на Java/Kotlin список объявлений с постраничной подгрузкой контента (limit, offset).
·       Ячейка объявления должна содержать:
·    Листалку фото (заглушку, если фото отсутствует) (ключ photos)
·    Форматированную цену в рублях  (пример 120 500 ₽)  (ключ params.price)
·    Комнатность (ключ params.rooms_count)
·    Адрес состоящий из улицы и номера дома (первый объект в массиве params.house_addresses)
·    Форматированную информацию о размерах жилплощади в квадратных метрах без дробной части (ключи params.total_area (общая),  params.living_area (жилая), params.kitchen_area (кухня) значения приходят в квадратных дециметрах)
·    Этажность (ключи params.floors_count (этажей в доме), params.floor (этаж квартиры))
·      По нажатию на объявление должен происходить переход в карточку объявления (карточка выглядит так же как и в списке).

Поддержка Android API 19+
URL запроса
https://api.n1.ru/api/v1/offers/?filter[region_id]=1054&query[0][deal_type]=sell&query[0][rubric]=flats&query[0][status]=published&sort=-creation_date&limit=20&offset=0
