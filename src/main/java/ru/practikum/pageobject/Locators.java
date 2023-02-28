package ru.practikum.pageobject;

// Основное задание //
/*
                                                                       БЛОК 1 (Вопросы о важном):

Страница https://qa-scooter.praktikum-services.ru/

Вопрос 1: Сколько это стоит? И как оплатить?
By xpath:
".//div[@id='accordion__heading-4']"
или
".//div[text()='Сколько это стоит? И как оплатить?']"

Ответ на вопрос 1: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
By xpath:".//div[@id='accordion__panel-0']/p"

Вопрос 5: Можно ли продлить заказ или вернуть самокат раньше?
By xpath:
".//div[@id='accordion__heading-4']"
или
".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']"

Ответ на вопрос 5: Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
By xpath:
или
".//div[@id='accordion__panel-4']/p"




                                                                   БЛОК 2 (Заказ самоката):
Начальная страница: https://qa-scooter.praktikum-services.ru/

Кнопка "Заказать" (вверху)
By xpath:  ".//*[@class='Button_Button__ra12g']"

Кнопка "Заказать" (внизу)
By xpath:  ".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']"

https://qa-scooter.praktikum-services.ru/order
^^^^^^^^ страница Формы заказа после нажатия "Заказать"


                       ФОРМА ЗАКАЗА:

Блок формы заказа № 1
xpath:   ".//div[@class='Order_Form__17u6u']"

Поле "Имя"
xpath:  ".//*[@placeholder='* Имя']"

Поле "Фамилия"
By xpath:  ".//*[@placeholder='* Фамилия']"

Поле "Адрес"
By xpath:  ".//*[@placeholder='* Адрес: куда привезти заказ']"

    //Выбор станции метро://
Поле "Cтанция метро"  By xpath:  ".//*[@class='select-search__input']"
Выбор станции "Бульвар Рокосовского" By xpath: ".//*[@class='select-search__row' and @data-index='0']"

Поле "Телефон"
By xpath:  ".//*[@placeholder='* Телефон: на него позвонит курьер']"

кнопка "ДАЛЕЕ" (переход к второй части заказа)
By xpath:  ".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']"


                        ФОРМА ЗАКАЗА № 2:

Блок формы заказа № 2
By xpath:   ".//div[@class='Order_Form__17u6u']"

Поле "Дата доставки"
By xpath: ".//*[@placeholder='* Когда привезти самокат']"

      //Выбор срока аренды://
Поле "Срок аренды" By xpath: ".//*[@class='Dropdown-control']"
Выбор срока = двое суток  By xpath: ".//*[@class='Dropdown-option' and text()='двое суток']"

      //Чек-бокс "Цвет самоката"//
Черный жемчуг  By xpath:  ".//*[@class='Checkbox_Input__14A2w' and @id='black']"
Серая безысходность By xpath: ".//*[@class='Checkbox_Input__14A2w' and @id='grey']"

Поле "Комментарий для курьера"
By xpath:  ".//*[@placeholder='Комментарий для курьера']"

Кнопка "ЗАКАЗАТЬ"
By xpath:  ".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"

Окно "Хотите оформить"
By xpath:  ".//*[@class='Order_Modal__YZ-d3']"

Подтверждение заказа (в окне "Хотите оформить" нажать на ДА)
By xpath:  ".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"

Окно-сообщение об оформленном заказе
By xpath: ".//*[@class='Order_ModalHeader__3FDaJ']"



*/