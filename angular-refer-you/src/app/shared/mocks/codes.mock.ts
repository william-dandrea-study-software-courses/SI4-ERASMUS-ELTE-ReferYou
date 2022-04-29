import {Code} from "../../core/models/code.model";
import {User} from "../../core/models/user.model";
import {Website} from "../../core/models/website.model";
import {Sponsor} from "../../core/models/sponsor.model";
import {Rating} from "../../core/models/rating.model";


export let CODES: Code[] = [
  {
    code_id: 0,
    user_id: 1,
    website_id: 0,
    code_value: "30% reduction at the inscription",
    description: "You need to go on the website and do ...",
    expiration_date: new Date(2023, 4, 13),
    creation_date: new Date(),
    number_of_uses: 5,
    redirect_url: "",
  },
  {
    code_id: 1,
    user_id: 3,
    website_id: 0,
    code_value: "30% reduction at the inscription",
    description: "You need to go on the website and do ...",
    expiration_date: new Date(2023, 2, 13),
    creation_date: new Date(),
    number_of_uses: 8,
    redirect_url: "",
  },
  {
    code_id: 2,
    user_id: 2,
    website_id: 1,
    code_value: "30% reduction at the inscription",
    description: "You need to go on the website and do ...",
    expiration_date: new Date(2023, 5, 13),
    creation_date: new Date(),
    number_of_uses: 2,
    redirect_url: "",
  },
  {
    code_id: 3,
    user_id: 3,
    website_id: 1,
    code_value: "30D584",
    description: "You need to go on the website and do ...",
    expiration_date: new Date(2023, 12, 13),
    creation_date: new Date(),
    number_of_uses: 4,
    redirect_url: "",
  },
  {
    code_id: 4,
    user_id: 1,
    website_id: 3,
    code_value: "4HFKDR",
    description: "You need to go on the website and do ...",
    expiration_date: new Date(2022, 8, 13),
    creation_date: new Date(),
    number_of_uses: 10,
    redirect_url: "",
  },
  {
    code_id: 5,
    user_id: 1,
    website_id: 2,
    code_value: "GDFKEO",
    description: "You need to go on the website and do ...",
    expiration_date: new Date(2023, 4, 13),
    creation_date: new Date(),
    number_of_uses: 2,
    redirect_url: "",
  },
]


export let USERS: User[] = [
  {
    user_id: 0,
    mail: "dhdjfk@gmail.com",
    password: "password",
    is_ban: false,
  },
  {
    user_id: 1,
    mail: "salut@gmail.com",
    password: "password",
    is_ban: false,
  },
  {
    user_id: 2,
    mail: "welcome@gmail.com",
    password: "password",
    is_ban: false,
  },
  {
    user_id: 3,
    mail: "yoooo@gmail.com",
    password: "password",
    is_ban: true,
  }
]


export let WEBSITES: Website[] = [
  {
    website_id: 0,
    url: "www.binance.com",
    description: "Crypto exchange",
  },
  {
    website_id: 1,
    url: "www.bitmex.com",
    description: "Crypto exchange",
  },
  {
    website_id: 2,
    url: "www.bybit.com",
    description: "Crypto exchange",
  },
  {
    website_id: 3,
    url: "www.revolut.com",
    description: "Banque",
  },
  {
    website_id: 4,
    url: "www.coinbase.com",
    description: "Crypto exchange",
  }
]


export let SPONSORS: Sponsor[] = [
  {
    code_id: 0,
    user_id: 1,
    amount: 20,
  },
  {
    code_id: 2,
    user_id: 1,
    amount: 30,
  },
  {
    code_id: 3,
    user_id: 2,
    amount: 20,
  },
  {
    code_id: 2,
    user_id: 0,
    amount: 100,
  }
]

export let RATINGS: Rating[] = [
  {
    code_id: 1,
    user_id: 2,
    is_negative: true,
    is_positive: false,
  },
  {
    code_id: 1,
    user_id: 3,
    is_negative: true,
    is_positive: false,
  },
  {
    code_id: 0,
    user_id: 0,
    is_negative: false,
    is_positive: true,
  },
  {
    code_id: 0,
    user_id: 1,
    is_negative: true,
    is_positive: true,
  },
]
